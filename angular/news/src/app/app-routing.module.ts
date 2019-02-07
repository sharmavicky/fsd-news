import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { HomepageComponent } from './homepage/homepage.component';
import { AdminComponent } from './admin/admin.component';
import { ArticleComponent } from './article/article.component';
const routes: Routes = [
{path:"", component:LoginComponent},
{path:"login", component:LoginComponent},
{path:"signup", component:SignupComponent},
{path:"home", component:HomepageComponent},
{path:"admin", component:AdminComponent},
{path:"article", component:ArticleComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
