import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bai1',
  templateUrl: './bai1.component.html',
  styleUrls: ['./bai1.component.css']
})
export class Bai1Component implements OnInit{
  num1: 0;
  num2: 0;
  result: number;


  addition() {
    this.result = this.num1 + this.num2;
  }

  subtraction() {
    this.result = this.num1 - this.num2;
  }

  multiplication() {
    this.result = this.num1 * this.num2;
  }
  division() {
    this.result = this.num1 / this.num2;
  }


  ngOnInit(): void {
  }

  constructor() {
  }

}
