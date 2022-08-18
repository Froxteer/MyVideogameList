import {VideoGame} from "./VideoGame";
import {User} from "./User";
import {ListConcept} from "./ListConcept";

export interface VideoGameUser {
  id: number
  videoGame: VideoGame
  user: User
  listConcept: ListConcept
}
