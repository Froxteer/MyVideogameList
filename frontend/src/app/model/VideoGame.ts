import {Genre} from "./Genre";
import {Platform} from "./Platform";
import {Developer} from "./Developer";

export interface VideoGame {
  id: number
  title: string
  releaseDate: Date
  description: string
  mainImage: string
  genres?: Genre[]
  platforms?: Platform[]
  developer?: Developer
}
