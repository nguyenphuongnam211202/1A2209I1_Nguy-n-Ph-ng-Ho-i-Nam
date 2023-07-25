package com.codegym.Controller;

import com.codegym.Entity.Address;
import com.codegym.Entity.Client;
import com.codegym.Entity.FootballPitches;
import com.codegym.Service.IAddressService;
import com.codegym.Service.IClientService;
import com.codegym.Service.IFootballPitchesService;
import com.codegym.Service.ITimeForRentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/Home")
public class ControllerFootball {
    private final IFootballPitchesService iFootballPitchesService;
    private final IAddressService iAddressService;
    private final ITimeForRentService iTimeForRentService;

    private final IClientService iClientService;

    public ControllerFootball(IFootballPitchesService iFootballPitchesService, IAddressService iAddressService, ITimeForRentService iTimeForRentService, IClientService iClientService) {
        this.iFootballPitchesService = iFootballPitchesService;
        this.iAddressService = iAddressService;
        this.iTimeForRentService = iTimeForRentService;
        this.iClientService = iClientService;
    }

    @GetMapping("/List")
    public String showList(Model model) {
        return listByPage(model,1 );
    }

    @GetMapping("List/page/{pageNumber}")
    public String listByPage (Model model, @PathVariable("pageNumber") Integer currentPage) {
        Page<FootballPitches> page = iFootballPitchesService.findAll(currentPage);
        List<FootballPitches> listPitches = page.getContent();

        Long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("listPitches", listPitches);
        model.addAttribute("address", iAddressService.findAll());
        model.addAttribute("time", iTimeForRentService.findAll());
        return "view/List";
    }

    @GetMapping("/Create")
    public String showCreate(Model model) {
        model.addAttribute("listPitches", new FootballPitches());
        model.addAttribute("address", iAddressService.findAll());
        model.addAttribute("time", iTimeForRentService.findAll());
        return "view/Create";
    }

    @PostMapping("/Create")
    public String doCreate(@Validated @ModelAttribute("listPitches") FootballPitches footballPitches, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("address", iAddressService.findAll());
            model.addAttribute("time", iTimeForRentService.findAll());
            return "/view/Create";
        }
        iFootballPitchesService.create(footballPitches);
        return "redirect:/Home/List";
    }

    @GetMapping("/MyOrder")
    public ModelAndView showMyOrder() {
        ModelAndView modelAndView = new ModelAndView("order/MyOrder");
        modelAndView.addObject("client", iClientService.findAll());
        return modelAndView;
    }

    @GetMapping("/Order/{id}")
    public String showOrder(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("listPitches", iFootballPitchesService.findById(id));
        model.addAttribute("client", new Client());
        return "order/Order";
    }

    @PostMapping("/Order")
    public String doOrder(@Validated @ModelAttribute("client") Client client, BindingResult bindingResult,
                          @RequestParam("id") Integer id, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("listPitches", iFootballPitchesService.findById(id));
            return "/order/Order";
        }
        client.setFootballPitches(iFootballPitchesService.findById(id));
        iClientService.order(client);
        return "redirect:/Home/MyOrder";
    }

    @GetMapping("/Edit/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("listPitches", iFootballPitchesService.findById(id));
        model.addAttribute("address", iAddressService.findAll());
        model.addAttribute("time", iTimeForRentService.findAll());
        return "view/Edit";
    }

    @PostMapping("/Edit")
    public String doEdit(@ModelAttribute("listPitches") FootballPitches footballPitches) {
        iFootballPitchesService.create(footballPitches);
        return "redirect:/Home/List";
    }

    @GetMapping("/Delete/{id}")
    public String doDelete(@RequestParam("id") Integer id) {
        iFootballPitchesService.delete(id);
        return "redirect:/Home/List";
    }

    @GetMapping("/Search")
    public String search(@RequestParam("name") String name, Model model) {
        List<FootballPitches> footballPitches = iFootballPitchesService.findFootballPitchesByNamePitchesContaining(name);
        model.addAttribute("listPitches",footballPitches);
        model.addAttribute("name", name);
        return "view/List";
    }
}
