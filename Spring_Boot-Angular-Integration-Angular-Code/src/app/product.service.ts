import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  basePath:string="http://localhost:2323/prod";

  constructor(private http:HttpClient) { }

  //Get all data from boot application
    getAllProducts():Observable<Product[]>{
      return this.http.get<Product[]>(`${this.basePath}/all`);
    }
  //delete product  in boot application
  deleteOneProduct(id:number):Observable<any>{
    return this.http.delete(`${this.basePath}/remove/${id}`,{responseType: "text"});
  }
  //insert product 
  saveProduct(prod:Product):Observable<any>{
    return this.http.post(`${this.basePath}/insert`,prod,{responseType:'text'});
  }
  //Get on product
  getOneProduct(id:number):Observable<Product>{
   return this.http.get<Product>(`${this.basePath}/one/${id}`);
  }
}
