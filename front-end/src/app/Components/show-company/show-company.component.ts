import { Component, OnInit, Input } from '@angular/core';
import { Company } from '../../models/Company';
import { CompanyServiceService } from '../../services/company-service.service';

@Component({
  selector: 'app-show-company',
  templateUrl: './show-company.component.html',
  styleUrls: ['./show-company.component.css']
})
export class ShowCompanyComponent implements OnInit {

  constructor(private companyService:CompanyServiceService) { }
  @Input()
  company: Company;

  showEditBox:boolean=false;
  placeholder:string;
  editProperty:any;
  name:string;
  ngOnInit(): void {
    console.log("show-company called")
  }

  onEdit(placeholder:string){
    this.showEditBox = !this.showEditBox;
    this.placeholder = placeholder;
  }

  updateCompany(company:Company){
    console.log(company)
    let name: string = company.companyName;
    switch(this.placeholder){
      case "Company Name":
        company.companyName = this.editProperty;
        break;
      case "Turnover":
        company.turnover = Number(this.editProperty);
        break;
      case "Company Details":
        company.companyDetails = this.editProperty;
        break;
      case "Sector Name":
        company.sectorName = this.editProperty;
        break;
    }
    this.placeholder =null;
    this.showEditBox =false;
    this.companyService.updateCompany(company,name );
    this.editProperty=null

  }

  showIpo(company:Company){
    this.company.showIpo = !this.company.showIpo;
  }

}
