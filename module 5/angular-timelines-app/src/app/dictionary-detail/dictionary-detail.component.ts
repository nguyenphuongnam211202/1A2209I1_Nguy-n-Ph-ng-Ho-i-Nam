import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {DictionaryService} from '../service/dictionary.service';

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {

  word = '';
  mean = '';

  constructor(private route: ActivatedRoute, private dictionaryService: DictionaryService) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const word = params.get('word');
      if (word) {
        this.word = word;
        this.mean = this.dictionaryService.translate(word);
      }
    });

  }
  }
