package modelo;
import modelo.Router;

public class Singletone {
	private Router router1 = null;
	private Router router2 = null;
	private Router router3 = null;
	private Router router4 = null;
	
	public Singletone() {
		super();
		router1 = new Router("AI1",500,"Agente1","Agente5",null);
		router2 = new Router("AI2",600,"Agente1","Agente2","Agente4");
		router3 = new Router("AI3",550,"Agente2","Agente3",null);
		router4 = new Router("AI4",650,"Agente3","Agente4","Agente5");
	}

	public Router getRouter1() {
		return router1;
	}

	public void setRouter1(Router router1) {
		this.router1 = router1;
	}

	public Router getRouter2() {
		return router2;
	}

	public void setRouter2(Router router2) {
		this.router2 = router2;
	}

	public Router getRouter3() {
		return router3;
	}

	public void setRouter3(Router router3) {
		this.router3 = router3;
	}

	public Router getRouter4() {
		return router4;
	}

	public void setRouter4(Router router4) {
		this.router4 = router4;
	}
	
}
