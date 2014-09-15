class Song
    #Ruby version of a constructor
    def initialize(name, artist, duration)
        @name = name
        @artist = artist
        @duration = duration
    end
    
    #Getter methods
    attr_reader :name, :artist, :duration
    attr_writer :name, :artist, :duration

    #Can be written in shorthand by attr_reader
    # def name
    #     @name
    # end
    
    #Can be written in shorthand by attr_writer
    # def name=(new_name)
    #     @name = new_name
    # end

    def to_s
        "Song: #@name--#@artist (#@duration)"
    end

    #Or private :hello
    private 
    def hello
        puts "Hi"
    end

    #Or public :helloGetter
    public
    def  helloGetter
        hello #Or hello()
    end
end

class KarokeSong < Song  #Sub class of Song
    def initialize(name, artist, duration, lyrics)
        super(name, artist, duration) #Call to the song super constructor
        @lyrics = lyrics
    end

    def to_s
        "Song: #@name--#@artist (#@duration) #@lyrics"
    end
end

song = KarokeSong.new("Dave","Air",123,"Hey hey hey")
puts song.to_s
puts song.name
song.name = "In Bloom"
puts song.name
song.helloGetter
