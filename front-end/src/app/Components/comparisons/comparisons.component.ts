import { Component, OnInit } from '@angular/core';
import { Company } from '../../models/Company'
import { CompanyServiceService } from 'src/app/services/company-service.service';

@Component({
  selector: 'app-comparisons',
  templateUrl: './comparisons.component.html',
  styleUrls: ['./comparisons.component.css']
})
export class ComparisonsComponent implements OnInit {

  constructor(private companyService: CompanyServiceService) { }

  companyList:Company[];
  companyNameList:Company[];
  company:Company = {
     companyName: '',
     companyDetails:'',
     sectorName: '',
     turnover:null,
     showIpo:false
  }

  message:string;
  showAddCompany:boolean = false;
  companyRegistered:boolean = false;
  showSearched:boolean = false;
  showEditBox:boolean = false;
  companyName:string = '';

  ngOnInit(): void {
  }



  onAdd(){
    this.company ={
      companyName: '',
      companyDetails:'',
      sectorName: '',
      turnover:null,
      showIpo:false
    };
    this.showAddCompany = !this.showAddCompany;
    this.showSearched = false;
    this.companyRegistered = false;
  }

  onChange(){
    // console.log(this.companyName);
    this.companyService.getByLikeName(this.companyName).subscribe(data =>{
      this.companyNameList = data;
    })

  }

  getAll(){
    this.showAddCompany = false;
    this.companyRegistered = false;
    this.showSearched = true;
    this.companyService.getAll().subscribe(data =>{

      this.companyList = data;
      console.log(this.companyList)
    })
  }

  getCompany(name:string){
    this.showAddCompany = false;
    this.companyRegistered = false;
    this.showSearched = true;
    this.companyNameList= [];
    this.companyName ='';
    this.companyService.getByName(name).subscribe(data =>{
      this.companyList = [data];
    })
  }


}
