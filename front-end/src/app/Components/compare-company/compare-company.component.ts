import { Component, OnInit } from '@angular/core';
import { Company } from '../../models/Company'
import { CompanyServiceService } from '../../services/company-service.service';

@Component({
  selector: 'app-compare-company',
  templateUrl: './compare-company.component.html',
  styleUrls: ['./compare-company.component.css']
})
export class CompareCompanyComponent implements OnInit {

  constructor(private companyService: CompanyServiceService) { }

  companyList:Company[];
  companyNameList:Company[];
  searchedCompany:Company = {
     companyName: '',
     companyDetails:'',
     sectorName: '',
     turnover:null,
     showIpo:false
  }


  showSearched:boolean = false;
  companyName:string = '';
  isAdmin:boolean=false;
  showChart:boolean=false;

  ngOnInit(): void {
  }


  onShowChart(){
    this.showSearched=false;
    this.showChart=!this.showChart;
    this.companyService.getAll().subscribe(data =>{
      this.companyList = data;
      console.log(this.companyList)
    })
  }
  onChange(){
    // console.log(this.companyName);
    this.companyService.getByLikeName(this.companyName).subscribe(data =>{
      this.companyNameList = data;
    })
  }

  getAll(){
    this.showSearched = !this.showSearched;
    this.showChart=false;
    this.companyService.getAll().subscribe(data =>{
      this.companyList = data;
      console.log(this.companyList)
    })
  }

  getCompany(name:string){
    this.showSearched = true;
    this.companyNameList= [];
    this.companyName ='';
    this.companyService.getByName(name).subscribe(data =>{
      this.companyList = [data];
    })
  }

}
