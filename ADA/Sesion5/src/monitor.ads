with Ada; use Ada;
with Ada.Real_Time; use Ada.Real_Time;
with Ada.Real_Time.Timing_Events;
use Ada.Real_Time.Timing_Events;
with Text_IO;
package Monitor is
	entradaJitterControl:Ada.Real_Time.Timing_Events.Timing_Event;
	--400ms -20ms del imputt jitter
	entradaPeriodo:Ada.Real_Time.Time_Span:=Ada.Real_Time.Milliseconds(3000);

	protected type codigoControlador is
		procedure generar(code: out Integer); --diapositiva 5 tema 7
		procedure validar(valor: in Integer);
		procedure Timer (event:in out Ada.Real_Time.Timing_Events.Timing_Event); --diapositiva19
	private
		nextTime:Ada.Real_Time.Time;
		dato:Integer;
   end codigoControlador;
end Monitor;
