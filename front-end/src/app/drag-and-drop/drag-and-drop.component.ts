import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { map } from "rxjs/operators";
import {DragDropModule} from '@angular/cdk/drag-drop';
import {ScrollingModule} from '@angular/cdk/scrolling';
import {CdkTableModule} from '@angular/cdk/table';
import {CdkTreeModule} from '@angular/cdk/tree';
import { DragAndDropService } from '../../service/dragDrop.service';

@Component({
  selector: 'app-drag-and-drop',
  templateUrl: './drag-and-drop.component.html',
  styleUrls: ['./drag-and-drop.component.css']
})
export class DragAndDropComponent implements OnInit {
  title = 'Angular 7 – Virtual Scrolling and Drag and Drop features';
  nameItems: any ;
  nameFile : String ;
  show :number = 0;
  constructor(public dragdropService:DragAndDropService) {
   /* for (let index = 0; index < this.names.length; index++) {
      this.nameItems.push(this.names[index]);
    }*/
  }

  ngOnInit() {
    this.show = 0;
    this.dragdropService.getAllFiles()
    .subscribe((data :any )=>{
      this.nameItems = data ;
    },err =>{
      console.log(err);
      
    })
  }

}
