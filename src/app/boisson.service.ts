import { Injectable } from '@angular/core';
import { Boisson } from './model/boisson.model';
import { Type } from './model/type.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TypeWrapper } from './model/TypeWrapped.model';
const httpOptions = {headers: new HttpHeaders( {'Content-Type': 'application/json'} )
};

@Injectable({
  providedIn: 'root'
})
export class BoissonService {
  apiURL: string = 'http://localhost:8090/boisson/api';
  apiURLType: string = 'http://localhost:8090/boisson/type';
  constructor(private http : HttpClient) {
    
    }
    rechercherParNom(nom: string):Observable< Boisson[]> {
      const url = `${this.apiURL}/boisByName/${nom}`;
      return this.http.get<Boisson[]>(url);
      }
      ajouterType( t: Type):Observable<Type>{
        return this.http.post<Type>(this.apiURLType, t, httpOptions);
        }
       
    listetypes():Observable<TypeWrapper>{
      return this.http.get<TypeWrapper>(this.apiURLType);
      }
    listeBoisson(): Observable<Boisson[]>{
      return this.http.get<Boisson[]>(this.apiURL);
      }
      ajouterBoisson( bois: Boisson):Observable<Boisson>{
        return this.http.post<Boisson>(this.apiURL, bois, httpOptions);
        }
  
        supprimerBoisson(id : number) {
          const url = `${this.apiURL}/${id}`;
          return this.http.delete(url, httpOptions);
          }
          consulterBoisson(id: number): Observable<Boisson> {
            const url = `${this.apiURL}/${id}`;
            return this.http.get<Boisson>(url);
            }
    

  updateBoisson(b :Boisson) : Observable<Boisson>
  {
  return this.http.put<Boisson>(this.apiURL,  b, httpOptions);
  }

    
  
     rechercheParType( id:number):Observable< Boisson[]> {
      const url = `${this.apiURL}/prodscat/${id}`;
      return this.http.get<Boisson[]>(url);

     }
     
}
