import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import {  ReactiveFormsModule} from '@angular/forms';
import { FormsModule } from '@angular/forms';
import {  HttpClientModule } from '@angular/common/http';
import { HomepageComponent } from './homepage/homepage.component';
import { AdminComponent } from './admin/admin.component';
import { ArticleComponent } from './article/article.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SignupComponent,
    LoginComponent,
    HomepageComponent,
    AdminComponent,
    ArticleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
  ReactiveFormsModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
