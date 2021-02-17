import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-register',
  templateUrl: './product-register.component.html',
  styleUrls: ['./product-register.component.css']
})
export class ProductRegisterComponent implements OnInit {
  //Create one form form backing object that store form data
  prod:Product=new Product();
  message:any;
  //dependency injection of service
  constructor(private service:ProductService) {}

  ngOnInit() {
  }
  saveProdData(){
    this.service.saveProduct(this.prod).subscribe(
      data=>{
        this.message=data;
        this.prod=new Product();
      },
      error=>{
        console.log(error);
      }      
    );
  }
}
