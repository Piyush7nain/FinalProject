import { Component, OnInit, Input } from '@angular/core';

import { Stock } from '../../models/Stock'
import { RegisteredCompany} from '../../models/RegisteredCompany'

import { StockExService } from 'src/app/services/stock-ex.service';
import { StocksService } from 'src/app/services/stocks.service';
import { ThrowStmt } from '@angular/compiler';


@Component({
  selector: 'app-show-stocks',
  templateUrl: './show-stocks.component.html',
  styleUrls: ['./show-stocks.component.css']
})
export class ShowStocksComponent implements OnInit {

  constructor(private stockExService:StockExService, private stockService: StocksService ) { }

  stocks: Stock[]
  newStock:Stock;
  registeredCompanies:RegisteredCompany[]

  @Input()
  stockCode:string;
  addCompanyName;

  showAddForm:boolean = false;
  showUploadExcel:boolean =false;

  ngOnInit(): void {

    this.stockService.getAllStocksByStockCode(this.stockCode).subscribe(data =>this.stocks = data);
    this.stockExService.getAllRegisteredCompany(this.stockCode).subscribe(data => this.registeredCompanies =data);
  }

  onAddOneStock(){
    this.showAddForm = !this.showAddForm;
    this.showUploadExcel= false;
    this.newStock ={
      companyCode:'',
      stockCode:'',
      date:null,
      time:'',
      currentPrice:null
    }
  }

  addOneStock(){
    this.showAddForm=false;
    this.stockService.addOneStock(this.newStock, this.addCompanyName).subscribe(data =>{
      this.stockService.getAllStocksByStockCode(this.stockCode).subscribe(data => this.stocks = data);
    })
  }

}
