import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticleComponent } from './article.component';
import { LoginComponent } from '../login/login.component';
import { SignupComponent } from '../signup/signup.component';
import { HomepageComponent } from '../homepage/homepage.component';
import { AdminComponent } from '../admin/admin.component';
import { BrowserModule  , By} from '@angular/platform-browser';
import { AppRoutingModule } from '../app-routing.module';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { APP_BASE_HREF } from '@angular/common';
import { NewsService } from '../news.service';
import { DebugElement } from '@angular/core';


fdescribe('ArticleComponent', () => {
  let component: ArticleComponent;
  let fixture: ComponentFixture<ArticleComponent>;
  let de : DebugElement;
  let el : HTMLElement
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [LoginComponent, SignupComponent, HomepageComponent, AdminComponent ,ArticleComponent],
      imports: [
        BrowserModule,
        AppRoutingModule,
        ReactiveFormsModule,
        HttpClientModule,
        FormsModule],
      providers: [{provide : APP_BASE_HREF  , useValue:'/'},
                    NewsService]
         })
    .compileComponents().then(()=>{
      fixture = TestBed.createComponent(ArticleComponent);
      component = fixture.componentInstance;
      de= fixture.debugElement.query(By.css(''));
      el=de.nativeElement;
    });
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  /* it('should create', () => {
    expect(component).toBeTruthy();
  }); */










});
