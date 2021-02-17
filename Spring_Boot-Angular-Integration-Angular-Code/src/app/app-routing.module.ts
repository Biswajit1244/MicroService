import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductAllComponent } from './product-all/product-all.component';
import { ProductEditComponent } from './product-edit/product-edit.component';
import { ProductRegisterComponent } from './product-register/product-register.component';


const routes: Routes = [
  {path:'all',component:ProductAllComponent},
  {path:'create',component:ProductRegisterComponent},
  {path:'edit/:id',component:ProductEditComponent},
  {path:"",redirectTo:'all',pathMatch:'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
