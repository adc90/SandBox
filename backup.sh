#Shell script to back up my capstone project


echo "//------------------------------------------"
echo "// Runing backup script"
echo "//------------------------------------------"

zip -r -q -T Game.zip Game && echo "Zip file written " || echo "Zip file failed"

backup=Game.zip
subject=$(date '+Backup [%l:%M %p %a %b %u]') 
recipient="aaronc81590@gmail.com"

if [ -e $backup ] 
then
	echo "Message body" | mutt -a "$backup" -s "$subject" -- $recipient	
fi

echo "Back up complete, sent to $recipient"

