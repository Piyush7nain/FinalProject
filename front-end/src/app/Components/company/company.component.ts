import { Component, OnInit } from '@angular/core';
import { Company } from '../../models/Company'
import { NONE_TYPE } from '@angular/compiler';
import { CompanyServiceService } from 'src/app/services/company-service.service';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

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

  ngOnInit(): void {
  }

  companyName:string = '';

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

  addCompany(){
    this.companyService.addNewCompany(this.company).subscribe(data =>{
    this.companyRegistered = true;
    this.showAddCompany = false;
    if(data == 'successful'){
      this.message = "Added " + this.company.companyName + " to Database";
    }else if(data == "failed"){
      this.message = "Company already exists in DataBase, try updating instead";
    }
    });
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
