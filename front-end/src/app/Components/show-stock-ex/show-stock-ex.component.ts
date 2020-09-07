import { Component, OnInit, Input } from '@angular/core';
import { StockEx } from 'src/app/models/StockEx';
import { StockExService } from 'src/app/services/stock-ex.service';

@Component({
  selector: 'app-show-stock-ex',
  templateUrl: './show-stock-ex.component.html',
  styleUrls: ['./show-stock-ex.component.css']
})
export class ShowStockExComponent implements OnInit {

  constructor(private stockExService: StockExService) { }

  @Input()
  stockEx: StockEx;

  showIpo:boolean = false;
  showStock:boolean = false;
  showCompany:boolean = false;

  ngOnInit(): void {
  }

  onShowIpo(){
    this.showIpo = !this.showIpo;
    this.showCompany=false;
    this.showStock =false;
  }
  onShowStocks(){
    this.showIpo = false;
    this.showCompany=false;
    this.showStock =!this.showStock;
  }
  onShowRegisteredCompany(){
    this.showIpo = false;
    this.showCompany=!this.showCompany;
    this.showStock =false;
  }


}
