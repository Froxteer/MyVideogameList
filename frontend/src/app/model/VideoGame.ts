import {Genre} from "./Genre";
import {Platform} from "./Platform";
import {Developer} from "./Developer";
import {VideoGameUser} from "./VideoGameUser";

export interface VideoGame {
  id: number
  title: string
  releaseDate: Date
  description: string
  mainImage: string
  genres?: Genre[]
  platforms?: Platform[]
  developer?: Developer
  videoGameUsers: VideoGameUser[]
}
