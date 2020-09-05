import { Component, OnInit } from '@angular/core';
import { StockExService } from 'src/app/services/stock-ex.service';
import { StockEx } from '../../models/StockEx'

@Component({
  selector: 'app-stock-ex',
  templateUrl: './stock-ex.component.html',
  styleUrls: ['./stock-ex.component.css']
})
export class StockExComponent implements OnInit {

  constructor(private stockExService: StockExService) { }

  stockExs: StockEx[]
  stockEx:StockEx;
  message:string;

  showAddForm:boolean = false;
  showStockExs:boolean=false;
  showMessage:boolean=false;

  ngOnInit(): void {
  }

  getExchange(){
    this.showAddForm = false;
    this.showStockExs = !this.showStockExs;
    this.stockExService.getAllExchanges().subscribe(data => this.stockExs = data);
  }

  onAdd(){
    this.showAddForm=!this.showAddForm;
    this.showStockExs = false;
    this.showMessage = false;
    this.stockEx ={
      stockExName:'',
      code:'',
      info:'',
      address:''
    };
  }

  addStockEx(){
    this.showAddForm= false;
    this.showMessage = true;
    this.stockExService.addStock(this.stockEx).subscribe(data=>{
      if(data.status == 'successful'){ 
        this.message = "Added New Stock Exchange to Database";
      }else if(data.status != 'successful') {
        this.message = "failed to add Stock Exchang to Database";
      }
    })
  }

  onUpload(){}
}
