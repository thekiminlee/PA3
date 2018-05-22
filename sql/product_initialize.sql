

DROP TABLE IF EXISTS products;

CREATE TABLE products (
	id int unsigned not null auto_increment,
	name varchar(50) not null,
	type varchar(50) not null,
	price varchar(7) not null,
	picture varchar(50) not null,
	image_count int not null,
	image_name varchar(30) not null,
	description longtext not null,
	PRIMARY KEY (id)
);

INSERT INTO products (name, type, price, picture, image_count, image_name, description) values
 ('MXR Dyna Comp Mini', 'Compressor' , '99.00', 'static/asset/item1/', 3, 'Dyna_Comp_', 'The Dyna Comp Compressor is one of the most popular compressors of all time.
					   Whether you want to tighten up your signal, add rich sustain, 
					   or create the percussive and clicky sound heard on numerous hit records, 
					   this pedal is straightforward and easy to use. 
					   For these reasons, the Dyna Comp Compressor has been the secret weapon on countless pedalboards for years.');

INSERT INTO products (name, type, price, picture, image_count, image_name, description) values 
 ('Digitech DOD 280 Compressor', 'Compressor' , '79.00', 'static/asset/item2/', 5, 'DOD_Comp_', 'With the DOD 280, you can tame the wildest peaks and even out dynamics between single notes and chords. 
					Deftly tear your way through licks that blend fretted notes and open strings without dramatic changes in volume. 
					The DOD Compressor 280 will help you manage the dynamic range of the input signal from your instrument. 
					Compressing your dynamic range will make notes sustain longer, the sound seem tighter and help you avoid clipping the signal going into other effects or your amplifier.');

INSERT INTO products (name, type, price, picture, image_count, image_name, description) values
 ('Fulltone Fulldrive 3', 'Dual Overdrive/Boost' , '139.00', 'static/asset/item3/', 5, 'Fulldrive3_', 'FD3 uses both a JFET input and a JFET op-amp, giving it the most tube-like sound you can get out of a tubeless pedal. 
					   Along with great sound, these JFET’s give the FD3 an ultra-high Input impedance which allows the pedal to mate with any type/gain of pickup and react well to changes in your guitar’s volume control.');

INSERT INTO products (name, type, price, picture, image_count, image_name, description) values
 ('Fulltone Fulldrive 2', 'Dual Stage Overdrive' , '129.00', 'static/asset/item4/', 3, 'Fulldrive2_', 'Housed in a beautiful powder coated Blue 16ga. steel enclosure, the dual-channel Full-Drive 2 Mosfet gives you the best of both worlds. 
					The first channel is the Overdrive Mode, capable of clean boost or non-compressed overdrive or choose light to medium softer overdrives all while retaining your guitar\'s original tone. 
					The Tone knob is a very effective presence control that can smooth out or add upper harmonics. The second channel is the "Boost Mode" with its own separate distortion control for medium to higher gains with a more singing violin-like sustain!');

INSERT INTO products (name, type, price, picture, image_count, image_name, description) values
 ('Ibanez Tube Screamer 9', 'Overdrive' , '99.00', 'static/asset/item5/', 3, 'TS9_','The TS9 Tube Screamer is one of the most imitated classic distortion pedals ever made. 
						Now you can get your hands on a reissue that\'s every bit as authentic as an original. 
						In fact, this TS9 Tube Screamer features the same components, housing, and seasick-green paint used to make the original models. They\'re even made in the same factory! What\'s even more important is that the sound is dead on.
						Discover classic stompbox distortion and drive - plug into an Ibanez TS9 Tube Screamer!');

INSERT INTO products (name, type, price, picture, image_count, image_name, description) values
 ('Ernie Ball Volume Pedal', 'Volume Pedal' , '99.00', 'static/asset/item6/', 4, 'EB_Volume_', 'The Ernie Ball VP Jr 250k provides all the same great features as our original volume pedal while reducing your footprint by 22%. 
						The VP 250k Jr is perfectly voiced for passive signals and features a compact, rugged design consisting of aircraft grade aluminum housing that is virtually indestructible. 
						Directly behind the input jack under the footplate is a micro taper switch which provides the user two distinct volume swell rates.');

INSERT INTO products (name, type, price, picture, image_count, image_name, description) values
 ('ZOOM MS50G Multistomp', 'Multistomp Pedal/Amp Modeler' , '99.00', 'static/asset/item7/', 2, 'ZOOM_MS_', 'Zoom\'s MS-50G MultiStomp guitar pedal combines the power of a multi-effects device and the flexibility of an amp modeler in a single compact stompbox. 
					With its 55 custom guitar effects and amp models, an easy-to-use interface, onboard chromatic tuner and versatile power options, you\'ll be surprised at  how much  the MS-50G has to offer.');

INSERT INTO products (name, type, price, picture, image_count, image_name, description) values
 ('Boss DD-500 Delay', 'Multi-Digital Delay' ,'349.00', 'static/asset/item8/', 3, 'DD500_', 'Filled with newly developed BOSS technology, the DD-500 is the most powerful and versatile stompbox delay ever created. 
					This incredible sound-creation toolbox offers 12 distinctive delay modes with exceptional audio quality, plus deep editing controls, a graphic display, patch memories, MIDI, and much more. From basic echo to dead-on emulations of classic delays to incredibly lush spatial textures that take your breath away, the DD-500 will launch your music places you never thought possible.');

INSERT INTO products (name, type, price, picture, image_count, image_name, description) values
 ('Boss RV-6 Reverb', 'Multi-reverb' , '129.00', 'static/asset/item9/', 2, 'RV6_', 'Combining high-end sound and wide-ranging versatility, the RV-6 takes pedal-based reverb to the next level.
					 Reaching beyond the capabilities of previous generations, this powerful stomp employs the latest tech and legendary BOSS know-how to make it easy to get amazing reverb tones instantly. 
					From subtle rooms to modern shimmer effects to long, evocative reverbs, the RV-6 envelops your tone in lush ambient spaces that endlessly inspire.');

INSERT INTO products (name, type, price, picture, image_count, image_name, description) values
 ('EHX Soul Food', 'Overdrive/Fuzz' , '99.00', 'static/asset/item10/', 4, 'SF_', 'The SOUL FOOD delivers transparent overdrive with great touch and response. 
						Its circuitry features boosted power rails to provide abundant headroom and increased definition. 
						Best of all, you don’t have to be a rock star to own one!');

