import { Component, OnInit } from '@angular/core';
import { NewsService } from '../news.service';
import { AuthService } from '../auth.service';


@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {

  constructor(private newService: NewsService, private authService: AuthService) { }

  favouriteArticle: any;
  id: any;
  user: any;
  ngOnInit() {
    this.id = this.authService.getUserId();
    this.newService.getUser(this.id).subscribe(data => {
      this.favouriteArticle = data.article;
      console.log(data);
      console.log(this.favouriteArticle);


    })
  }


  deleteArticle(title) {
    this.user = JSON.stringify({
      id: this.id,
      article: [{ title }]
    })
    this.newService.deleteArticle(this.user).subscribe(
      data => {
        this.newService.getUser(this.id).subscribe(data => {
          this.favouriteArticle = data.article;
          console.log(data);
          console.log(this.favouriteArticle);
        })

      })
  }


}
