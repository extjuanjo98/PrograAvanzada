package body Monitor is
   protected body codigoControlador is
      procedure generar (code: out Integer) is
         codi:Integer;
      begin
         codi:=1234;
         code:=codi;
         dato:=codi;
         delay  1.0;
         nextTime:=Clock+entradaPeriodo;
         Ada.Real_Time.Timing_Events.Set_Handler(entradaJitterControl,nextTime,timer'Access);
      end generar;

      procedure validar(valor: in Integer) is
      begin
         if valor=dato then
            Text_IO.Put_Line("Dato correcto");
            Ada.Real_Time.Timing_Events.Set_Handler(entradaJitterControl,nextTime,null);
         else
            Text_IO.Put_Line("Dato incorrecto");
         Ada.Real_Time.Timing_Events.Set_Handler(entradaJitterControl,nextTime,null);
         end if;
      end validar;

      procedure timer (event: in out Ada.Real_Time.Timing_Events.Timing_Event) is
      begin
         null;
         Text_IO.Put_Line("Alaarma");
      end timer;

   end codigoControlador;
end Monitor;
