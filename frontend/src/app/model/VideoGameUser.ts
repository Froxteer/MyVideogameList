import {ListConcept} from "./ListConcept";

export interface VideoGameUser {
  id: { videoGameId: number, userId: number }
  listConcept: ListConcept
}
