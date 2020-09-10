import { Component, OnInit, Input } from '@angular/core';
import { Company } from 'src/app/models/Company';
import { CompareInput } from '../../models/CompareInput';
import { ChartData } from '../../models/ChartData';
import { StocksService } from 'src/app/services/stocks.service';
import { Stock } from 'src/app/models/Stock';

@Component({
  selector: 'app-charts',
  templateUrl: './charts.component.html',
  styleUrls: ['./charts.component.css']
})
export class ChartsComponent implements OnInit {

  constructor(private stocksService: StocksService) { }

  ngOnInit(): void {
    this.compareInput={
      companyName:'',
      startDate:null,
      endDate:null
    }
  }

  @Input()
  companies:Company[];

  compareInput:CompareInput;
  addedCompanyName:string
  activeCompanyList:string[] = new Array();
  dataSource:ChartData[]=new Array();
  responseData: Stock[] = new Array();
  showChart:boolean= false;

  onAdd(){
    this.addedCompanyName = this.compareInput.companyName;
    let userInput:any={
      startDate:this.compareInput.startDate,
      endDate:this.compareInput.endDate
    }
    this.activeCompanyList.unshift(this.compareInput.companyName);
    this.stocksService.getByCompanyNameAndRange(this.compareInput.companyName, userInput).subscribe(data=>{
        this.responseData = data;
    });
    this.compareInput={
      companyName:"",
      startDate:null,
      endDate:null
    }
  }
  printResponse(){
    console.log(typeof(this.responseData[0].date))
    console.log(this.formatDate(this.responseData[0].date));
    //this.createChart();
  }

  createChart(){
    this.responseData.forEach(element => {
      let data:ChartData= new ChartData();
      data.companyName = this.addedCompanyName;
      data.date = this.formatDate(element.date);
      data.currentPrice = element.currentPrice;
      this.dataSource.push(data);
    });
    this.responseData = new Array();
    this.showChart= true;
    console.log(this.dataSource)
  }

  formatDate(stringDate:any):string{
    let arr:string[] = stringDate.substring(0,10).split("-", 3);
    return arr[2]+"/"+arr[1]+"/"+arr[0];
  }

  removeCompany(companyName:string){
    this.dataSource = this.dataSource.filter(ds => ds.companyName != companyName);
    this.activeCompanyList = this.activeCompanyList.filter(com => com != companyName);
    if(this.activeCompanyList.length == 0){
      this.showChart = false;
    }
  }


}
/*
let time:Date=new Date(this.compareInput.startDate);
    console.log(time)
    console.log("iso string => ",time.toISOString())
    console.log("normal string => ",time.toString())
    console.log("UTC sting => ",time.toUTCString())
    console.log("local string => " ,time.toLocaleString())
    console.log("to date strign =>",time.toDateString())
    console.log("added hours => ", new Date(time.setHours(22,22,22))); */
