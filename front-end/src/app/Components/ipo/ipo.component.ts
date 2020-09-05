import { Component, OnInit, Input } from '@angular/core';

import { Ipo } from '../../models/Ipo'
import { StockEx } from '../../models/StockEx'
import { IpoService } from 'src/app/services/ipo.service';
import { StockExService } from 'src/app/services/stock-ex.service';

@Component({
  selector: 'app-ipo',
  templateUrl: './ipo.component.html',
  styleUrls: ['./ipo.component.css']
})
export class IpoComponent implements OnInit {

  constructor(private ipoService:IpoService, private stockExService: StockExService) {}

  @Input()
  companyName:string;
  ipos:Ipo[];
  newIpo:Ipo ={
    companyCode:'',
    stockCode:'',
    pricePerShare:null,
    remarks:'',
    date:null
  }

  stockExs:StockEx[];
  showIpoForm:boolean = false;

  ngOnInit(): void {
    this.stockExService.getAllExchanges().subscribe(data => this.stockExs = data);
    this.ipoService.getAllIpo(this.companyName).subscribe(data=>{
      this.ipos= data;
    })
  }


  removeIpo(removeIpo:Ipo){
    let id = removeIpo.id;
    this.ipoService.removeIpo(id);
    this.ipos = this.ipos.filter((ipo)=>ipo.id !== removeIpo.id);
  }
  
  addIpo(){
    let name:string= this.companyName
    this.showIpoForm = false;
    this.ipoService.addIpo(this.newIpo, name).subscribe(data=>{
      if(data.status == 'successful'){
        this.ipoService.getAllIpo(this.companyName).subscribe(data=>{
          this.ipos= data;
        })
      }
    });
    this.newIpo=null;
  }
}
