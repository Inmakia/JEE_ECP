package controllers;

public abstract class ControllerFactory {
	public abstract VotarTemaController getVotarController();
	public abstract ViewVotesController getViewVotesController();
	public abstract AddTemaController getAddTemaController();
	public abstract DeleteTemaController getDeleteController();
}