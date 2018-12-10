import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { map } from "rxjs/operators";

const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

@Injectable()
export class DragAndDropService {

    constructor(public httpClient:HttpClient){
    }

    getAllFiles(){
      //  return this.httpClient.get("http://localhost:8080/fileHeaders?fileName=Korea_Policy_File_100k.csv")
      return this.httpClient.get("http://localhost:8080/allFiles")
        .pipe(map(resp => resp));
    }
    getHeadrs(name : any){
        return this.httpClient.get("http://localhost:8080/fileHeaders?fileName="+name)
        .pipe(map(resp => resp));
    }
    getSelectQuery(fileName, query){
        return this.httpClient.get("http://localhost:8080/select?fileName="+fileName+"&query="+query)
        .pipe(map(resp => resp));
    }

    getCombineQuery(fileName, query){
        return this.httpClient.get("http://localhost:8080/combine?fileName="+fileName+"&query="+query)
        .pipe(map(resp => resp));
    }

    getGroupByQuery(fileName, query){
        return this.httpClient.post("http://localhost:8080/groupby?fileName="+fileName+"&query="+query, httpOptions);
    }
}