import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-admin-navbar',
  templateUrl: './admin-navbar.component.html',
  styleUrls: ['./admin-navbar.component.css']
})
export class AdminNavbarComponent implements OnInit {

  constructor(private router:Router,
              private storageService:StorageService) { }

  ngOnInit(): void {
  }
  onLogout(){
    this.storageService.removeUserInfo();
    this.router.navigate(['login']);
  }
}
