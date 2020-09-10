import { Component, OnInit, Input } from '@angular/core';
import { RegisteredCompany} from '../../models/RegisteredCompany'
import { StockExService } from 'src/app/services/stock-ex.service';
import { Company } from 'src/app/models/Company';
import { CompanyServiceService } from 'src/app/services/company-service.service';

@Component({
  selector: 'app-show-registered-company',
  templateUrl: './show-registered-company.component.html',
  styleUrls: ['./show-registered-company.component.css']
})
export class ShowRegisteredCompanyComponent implements OnInit {

  constructor(private stockExService: StockExService, private companyService:CompanyServiceService) { }

  @Input()
  STOCKCODE:string;

  registeredCompanies:RegisteredCompany[];
  newCompany: RegisteredCompany;
  allCompanies: Company[];

  showAddForm:boolean = false;
  showErrorMessage:boolean=false;

  message:string;

  ngOnInit(): void {
    this.stockExService.getAllRegisteredCompany(this.STOCKCODE).subscribe(data => this.registeredCompanies = data);
  }

  onRegisterCompany(){
    this.showErrorMessage = false;
    this.showAddForm = !this.showAddForm;
    this.companyService.getAll().subscribe(data =>this.allCompanies = data);
    this.newCompany = {
      companyName:'',
      companyCode:'',
      stockCode: this.STOCKCODE
    }
  }

  registerCompany(){
    this.showAddForm =false;
    this.stockExService.registerCompany(this.newCompany).subscribe(data => {
      if(data.status =="successful"){
        this.showErrorMessage = false;
        this.stockExService.getAllRegisteredCompany(this.STOCKCODE).subscribe(data => this.registeredCompanies = data);
      }else if(data.status =="failed"){
        this.showErrorMessage= true;
        this.message = "Company already registered with this Exchange."
      }
    })
  }

  removeCompany(company:RegisteredCompany){
    this.stockExService.removeCompany(company).subscribe(data=>{
      if(data.status=="successful"){
        this.registeredCompanies = this.registeredCompanies.filter(com => com.companyCode != company.companyCode);
      }
    })
  }

}
