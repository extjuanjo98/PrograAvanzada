package Monitor is
  protected type variableControl is
      entry pedirTurno;
      entry entrarAtraccion;
      entry salirAtraccion;
   private
      seAcabo:Boolean:=False;
      salir:Integer:=0;
      bajar:Boolean:=False;
      nPasajeros : Integer := 0;
   end variableControl;
end Monitor;
