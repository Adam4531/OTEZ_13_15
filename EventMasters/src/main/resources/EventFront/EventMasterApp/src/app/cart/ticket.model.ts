export class Ticket {
  public name: string;
  public user: number;
  public price: number
  constructor(name: string, user: number, price: number) {
    this.name = name;
    this.user = user;
    this.price = price;
  }
}
