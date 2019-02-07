import { Component, OnInit } from '@angular/core';
import { NewsService } from '../news.service';
import { AuthService } from '../auth.service';
import { Serializer } from '@angular/compiler';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(private newservice: NewsService, private service: AuthService) { }
  languageCode: any;
  articleList: any;
  articles: any;
  favoriteArticleId: any;
  article: any;
  id: any;
  userData: any;
  key
  ngOnInit() {
    this.id = this.service.getUserId();
    //this.id=this.service.getUserId();
    this.languageCode = this.service.getLanguageCode();
    //this.languageCode = "en"
    this.newservice.getNews(this.languageCode).subscribe(data => {
      console.log(data)
      this.articleList = data.articles;
      //this.article=data;
    })
  }
  getNewsByKeyword(keyWords) {
    console.log(keyWords);
    this.newservice.getArticleUsingKeyWords(keyWords).subscribe(data => {
      this.articleList = data.articles;
      console.log(this.articleList);
    })
  }
  saveArticle(articleTitle) {
    //console.log(articleTitle);
    this.articleList.forEach(favoriteArticle => {
      // console.log(element.title);
      if (favoriteArticle.title == articleTitle) {
        console.log(favoriteArticle.title);
        // console.log(favoriteArticle)
        let user = JSON.stringify({
          id: this.service.getUserId(),
          article: [favoriteArticle]
        })
        console.log(user);
        this.newservice.saveArticle(user).subscribe(data => {
          this.favoriteArticleId = data;
          console.log(this.favoriteArticleId);
        })
      }
    });
  }




}



