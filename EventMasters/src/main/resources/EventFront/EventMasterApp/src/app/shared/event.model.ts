export class Event {
  public name: string;
  public description: string;
  public user: number;

  constructor(name: string, description: string, user: number) {
    this.name = name;
    this.description = description;
    this.user = user
  }
}
