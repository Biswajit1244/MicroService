import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  
  prod:Product=new Product();

  constructor(private ser:ProductService,private ar:ActivatedRoute,private route:Router) { }

  ngOnInit() {
      let id=this.ar.snapshot.params['id'];
      //get the data from service and load to page
      this.ser.getOneProduct(id).subscribe(
        data=>{
          this.prod=data;
        },
        error=>{
          console.log(error);
        }
      );
  }
  updateProdData(){
    this.ser.saveProduct(this.prod).subscribe(
      data=>{
        this.route.navigate(['all']);
      },error=>{
        console.log(error);
      }
    );
  }
}
