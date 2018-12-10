import { Component, OnInit, Input } from '@angular/core';
import {SelectItem} from 'primeng/api';
import { DragAndDropService } from '../../service/dragDrop.service';

@Component({
  selector: 'app-selection',
  templateUrl: './selection.component.html',
  styleUrls: ['./selection.component.css']
})
export class SelectionComponent implements OnInit {

  @Input('nameFile') nameFile : String ;
  columns: SelectItem[];
  selectedCols: string[] = [];
  checked: boolean = true;
  show : number = 0;
  finalQuery: string;
  constructor(public drapdropService:DragAndDropService) {}
  query: any = "";
  ngOnInit() {
    this.drapdropService.getHeadrs(this.nameFile).subscribe((data :any)=>{
      this.columns = data ;
    })
  }

  querySelect(id : any){
      this.query +=  id +" ";
      console.log(this.query)
    
  }

  onChange(col) {
    if(this.selectedCols.indexOf(col) < 0){
      this.selectedCols.push(col);
    }
    console.log(JSON.stringify(this.selectedCols));
}
save(){
  this.finalQuery ="SELECT ";
  for (let index = 0; index < this.selectedCols.length; index++) {
    this.finalQuery += this.selectedCols[index];
    if(index != this.selectedCols.length-1){
      this.finalQuery += ", ";
    }
  }
  this.finalQuery += " FROM " + this.nameFile.substring(0, this.nameFile.indexOf('.'));
  this.finalQuery += " " + this.query;
  console.log(this.finalQuery);
  this.show=1;
}
}
