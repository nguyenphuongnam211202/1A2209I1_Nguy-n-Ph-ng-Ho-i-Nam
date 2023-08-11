import { Injectable } from '@angular/core';
import {IWord} from '../../IWord';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  private words: IWord[] = [
    {word : 'hello', mean : 'xin chao'},
    {word : 'father', mean : 'ba'},
    {word : 'cat', mean : 'con meo'},
    {word : 'flower', mean : 'bong hoa'},
  ];

  translate(word: string): string {
    const foundWord = this.words.find(w => w.word.toLowerCase() === word.toLowerCase());
    return foundWord ? foundWord.mean : 'khong tim thay tu nay';
  }

  getAllWords(): IWord[] {
    return this.words;
  }
  constructor() { }
}
