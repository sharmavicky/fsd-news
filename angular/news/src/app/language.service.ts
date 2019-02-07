import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LanguageService {

  constructor(private http: HttpClient) { }

  getLanguageUrl: string = "/news/list/languages";

  getLanguage(): Observable<any> {
    return this.http.get(this.getLanguageUrl);
  }
}
