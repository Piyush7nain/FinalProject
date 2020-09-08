import { Component, OnInit, Input } from '@angular/core';

import { Stock } from '../../models/Stock'
import { RegisteredCompany} from '../../models/RegisteredCompany'

import { StockExService } from 'src/app/services/stock-ex.service';
import { StocksService } from 'src/app/services/stocks.service';
import { ThrowStmt } from '@angular/compiler';
import { StockEx } from 'src/app/models/StockEx';
import { CompanyServiceService } from 'src/app/services/company-service.service';


@Component({
  selector: 'app-show-stocks',
  templateUrl: './show-stocks.component.html',
  styleUrls: ['./show-stocks.component.css']
})
export class ShowStocksComponent implements OnInit {

  constructor(private stockExService:StockExService,
             private stockService: StocksService,
             private companyService: CompanyServiceService ) { }


  @Input()
  stockCode:string;

  @Input()
  isAdmin:boolean=false;

  @Input()
  companyName:string;

  @Input()
  where:string

  addCompanyName:string;
  showAddForm:boolean = false;
  stocks: Stock[]
  newStock:Stock;
  registeredCompanies:any
  stockExs: StockEx[];

  ngOnInit(): void {
    if(this.where =="stockEx"){
      console.log("show stocks called")
      this.stockService.getAllStocksByStockCode(this.stockCode).subscribe(data =>this.stocks = data);
      this.stockExService.getExchangeByCode(this.stockCode).subscribe(data=> this.stockExs= [data]);
      this.stockExService.getAllRegisteredCompany(this.stockCode).subscribe(data => this.registeredCompanies =data);
    }else if(this.where =="company"){
      console.log("show stocks called")
      this.stockService.getAllStocksByCompanyName(this.companyName).subscribe(data=> this.stocks= data);
      this.stockExService.getAllExchanges().subscribe(data=> this.stockExs = data);
      this.companyService.getByName(this.companyName).subscribe(data => this.registeredCompanies = [data]);
    }
  }

  onAddOneStock(){
    this.showAddForm = !this.showAddForm;
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
      if(data.status =='successful'){
      if(this.where ="company"){
        this.stockService.getAllStocksByCompanyName(this.companyName).subscribe(data=> this.stocks= data);
      }else if(this.where ="stockEx"){
        this.stockService.getAllStocksByStockCode(this.stockCode).subscribe(data => this.stocks = data);
      }
      }
    })
  }

}
