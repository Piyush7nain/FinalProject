import { Component, OnInit, Input } from '@angular/core';

import { Ipo } from '../../models/Ipo'
import { StockEx } from '../../models/StockEx'
import { IpoService } from 'src/app/services/ipo.service';
import { StockExService } from 'src/app/services/stock-ex.service';
import { CompanyServiceService } from 'src/app/services/company-service.service';

@Component({
  selector: 'app-ipo',
  templateUrl: './ipo.component.html',
  styleUrls: ['./ipo.component.css']
})
export class IpoComponent implements OnInit {

  constructor(private ipoService:IpoService,
              private stockExService: StockExService,
              private companyService: CompanyServiceService) {}

  @Input()
  companyName:string = null;
  @Input()
  isAdmin:boolean= false;
  @Input()
  where:string;

  ipos:Ipo[];

  @Input()
  stockCode:string = null;

  newIpo:Ipo

  registeredCompanies:any
  stockExs:StockEx[];
  showIpoForm:boolean = false;

  ngOnInit(): void {
    if(this.where=="company"){
      console.log("show ipo called from company")
      this.stockExService.getAllExchanges().subscribe(data => this.stockExs = data);
      this.ipoService.getAllIpoByCompanyName(this.companyName).subscribe(data=>{ this.ipos= data;})
      this.companyService.getByName(this.companyName).subscribe(data => this.registeredCompanies = [data]);
    } else if(this.where=="stockEx"){
      console.log("show ipo called from stockEx")
      this.stockExService.getExchangeByCode(this.stockCode).subscribe(data => { this.stockExs = [data] } )
      this.ipoService.getAllIpoByStockCode(this.stockCode).subscribe(data=>{this.ipos= data;})
      this.stockExService.getAllRegisteredCompany(this.stockCode).subscribe(data=> this.registeredCompanies=data);
      }

  }

  onAdd(){
    this.showIpoForm = !this.showIpoForm;
    this.newIpo ={
      companyCode:'',
      stockCode:'',
      pricePerShare:null,
      remarks:'',
      date:null
    }

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
        if(this.where=="company"){
          this.ipoService.getAllIpoByCompanyName(this.companyName).subscribe(data=> this.ipos = data)
        }else if(this.where=="stockEx"){
          this.ipoService.getAllIpoByStockCode(this.stockCode).subscribe(data=>{this.ipos= data;})
        }
      }
    });

  }
}
