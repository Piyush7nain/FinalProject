import { Component, OnInit, Input } from '@angular/core';
import { StockEx } from 'src/app/models/StockEx';

@Component({
  selector: 'app-stock-ex-add-form',
  templateUrl: './stock-ex-add-form.component.html',
  styleUrls: ['./stock-ex-add-form.component.css']
})
export class StockExAddFormComponent implements OnInit {

  constructor() { }
  
  @Input() 
  showForm:boolean;


  ngOnInit(): void {
  }

  addStockEx(){
    this.showForm = false;
  }

}
