import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '../auth.service';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
     constructor( private service : AuthService) { }
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // add authorization header with jwt token if available
       
        const currentUser = JSON.parse(sessionStorage.getItem('currentUser'));
        console.log('Interceter called');
        console.log(currentUser);
        //  const re = 'https://newsapi.org';
        const re = '/user';
        if (request.url.search(re) === -1) {

            if (currentUser && currentUser.token) {
                console.log('Token is being added....!!!!!');
                // console.log(currentUser.token);
                request = request.clone({
                    setHeaders: {
                        Authorisation: `Token ${currentUser.token}`,
                    }
                });
            }
            console.log('Request Sent :');
            console.log(request);
        }
        return next.handle(request);
    }
}
