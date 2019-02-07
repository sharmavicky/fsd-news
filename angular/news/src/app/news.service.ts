import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';


const httpOptions = {
  headers: new HttpHeaders(
    {
      'Content-Type': 'application/json',
    }
  )
};
@Injectable({
  providedIn: 'root'
})
export class NewsService {

  constructor(private http: HttpClient) { }

  apiKey: string = "f7017b3872114adda876173597532968";

  getNews(language): Observable<any> {
    let newsUrl: string = "https://newsapi.org/v2/top-headlines?language=" + language + "&apiKey=" + this.apiKey;
    return this.http.get(newsUrl);

  }
  savefavoriteArticleUrl = "/news/saveArticle"
  saveArticle(favoriteArticle) {

    //console.log("favoriteArticle"+favoriteArticle);
    return this.http.post(this.savefavoriteArticleUrl, favoriteArticle, httpOptions)

  }

  getArticleUsingKeyWords(keyWord): Observable<any> {
    let newUrlByKeywords: string = "https://newsapi.org/v2/top-headlines?q=" + keyWord + "&apiKey=" + this.apiKey
    return this.http.get(newUrlByKeywords);

  }

  getUserUrl = "/news/user/"
  getUser(id): Observable<any> {
    console.log(id);
    return this.http.get(this.getUserUrl + id);

  }
  deletearticleUrl = "/news/delete"
  deleteArticle(title): Observable<any> {
    console.log("inside delete");
    console.log(title)
    return this.http.post(this.deletearticleUrl, title, httpOptions);

  }
}

