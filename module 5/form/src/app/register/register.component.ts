import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  // tslint:disable-next-line:variable-name
  constructor(private _formBuilder: FormBuilder) {

  }

  ngOnInit(): void {
    this.registerForm=this._formBuilder.group({
      email: ['',[Validators.email, Validators.required]],
      password:['',[Validators.required, Validators.minLength(6)]],
      confirmPassword: ['',[Validators.required, Validators.minLength(6)]],
      country:['',[Validators.required]],
      age:['',[Validators.required,Validators.min(18)]],
      gender: ['',[Validators.required]],
      phoneNumber: ['',[Validators.required,Validators.pattern('^\\+84\\d{9}$')]]
    })
  }

  create() {

  }
}
