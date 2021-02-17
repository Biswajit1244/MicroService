import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Product } from '../product';
import { Router } from '@angular/router';


@Component({
  selector: 'app-product-all',
  templateUrl: './product-all.component.html',
  styleUrls: ['./product-all.component.css']
})
export class ProductAllComponent implements OnInit {

  products:Product[];
  message:any;

  constructor(private service:ProductService,private router:Router) { }

  ngOnInit() {
    this.getAllProducts();
  }
  getAllProducts(){
    this.service.getAllProducts()
      .subscribe(
        data=>{
          this.products=data
        },
        error=>{
          console.log(error)
        }
      );
    }

    deleteOneProduct(id:number){
      this.service.deleteOneProduct(id)
        .subscribe(
          data=>{
            this.message=data
            this.getAllProducts();
          },
          error=>{
            console.log(error)
          }
        );
    }

    editeOneProduct(id:number){
      this.router.navigate(["edit",id]);
    }
}
