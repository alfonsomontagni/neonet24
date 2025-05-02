@echo off
:menu
echo MENU SCAN FE by @ALFONSO MONTAGNI Eligere (need folder without spaces):
echo.
echo 0. COMPONENT all in one
echo 1. HTML
echo 2. TYPESCRIPT
echo 3. JSON
echo 4. CSS / SCSS
echo 5. ALL ABOVE plus .ts in ts format
echo 6. ONLY TYPESCRIPT in ts format
echo 7. ONLY Test Jasmine
echo 8. ALL BE: java, sql, properties, xml
echo 9. FE services
echo pam43. list of: pdf avi mkv mp4 mp3 EPUB
echo pdf. list pdf
echo avi. list avi
echo mkv. list mkv
echo mp4. list mp4
echo mp3. list mp3
echo epub. list epub
echo zip. list zip rar 7z
echo imm. list images png jpg jpeg bmp
echo 10. FINE
echo.
Set DirName=%cd%
For %%A in ("%dirname%") do (
    set currentDirectory=%%~nxA
)
set/p sc=
if %sc% == 0 goto componentallonly
if %sc% == 1 goto html
if %sc% == 2 goto typescript
if %sc% == 3 goto json
if %sc% == 4 goto css
if %sc% == 5 goto html
if %sc% == 6 goto typescriptts
if %sc% == 7 goto test
if %sc% == 8 goto java
if %sc% == 9 goto services
if %sc% == 10 goto fine
if %sc% == pam43 goto pdf
if %sc% == pdf goto pdf
if %sc% == avi goto avi
if %sc% == mkv goto mkv
if %sc% == mp4 goto mp4
if %sc% == mp3 goto mp3
if %sc% == epub goto epub
if %sc% == imm goto png
if %sc% == zip goto zip
if not %sc% == 10 goto fine
REM pause>nul
REM goto menu
REM copy *.txt [nuovofile.txt]

:zip
echo _ZIP search in dir e subdir from %currentDirectory%
dir /a /b /S /o:gen *.zip > %currentDirectory%_ZIP.txt
if %sc% == zip goto rar

:rar
echo _RAR search in dir e subdir from %currentDirectory%
dir /a /b /S /o:gen *.rar > %currentDirectory%_RAR.txt
if %sc% == rar goto a7z

:a7z
echo _7z search in dir e subdir from %currentDirectory%
dir /a /b /S /o:gen *.7z > %currentDirectory%_7z.txt
if %sc% == a7z goto menu

:png
echo _PNG search in dir e subdir from %currentDirectory%
dir /a /b /S /o:gen *.png > %currentDirectory%_PNG.txt
if %sc% == imm goto jpg

:jpg
echo _JPG search in dir e subdir from %currentDirectory%
dir /a /b /S /o:gen *.jpg > %currentDirectory%_JPG.txt
if %sc% == imm goto jpeg

:jpeg
echo _JPEG search in dir e subdir from %currentDirectory%
dir /a /b /S /o:gen *.jpeg > %currentDirectory%_JPEG.txt
if %sc% == imm goto bmp

:bmp
echo _BMP search in dir e subdir from %currentDirectory%
dir /a /b /S /o:gen *.bmp > %currentDirectory%_BMP.txt
if %sc% == imm goto menu

:pdf
echo _PDF search in dir e subdir from %currentDirectory%
dir /a /b /S /o:gen *.pdf > %currentDirectory%_PDF.txt
if %sc% == pam43 goto avi
if %sc% == pdf goto menu

:avi
echo _AVI search in dir e subdir from %currentDirectory%
dir /a /b /S /o:gen *.avi > %currentDirectory%_AVI.txt
if %sc% == pam43 goto mkv
if %sc% == avi goto menu

:mkv
echo _MKV search in dir e subdir from %currentDirectory%
dir /a /b /S /o:gen *.mkv > %currentDirectory%_MKV.txt
if %sc% == pam43 goto mp4
if %sc% == mkv goto menu

:mp4
echo _MP4 search in dir e subdir from %currentDirectory%
dir /a /b /S /o:gen *.mp4 > %currentDirectory%_MP4.txt
if %sc% == pam43 goto mp3
if %sc% == mp4 goto menu

:mp3
echo _MP3 search in dir e subdir from %currentDirectory%
dir /a /b /S /o:gen *.mp3 > %currentDirectory%_MP3.txt
if %sc% == pam43 goto epub
if %sc% == mp3 goto menu

:epub
echo _EPUB search in dir e subdir from %currentDirectory%
dir /a /b /S /o:gen *.epub > %currentDirectory%_EPUB.txt
if %sc% == pam43 goto menu
if %sc% == epub goto menu

:html
echo selezionato HTML
for /r %%i in (*.htm,*.html) do (

if not %%~nxi == %currentDirectory%_outputHTML.txt (
echo Directory e tipo:  %%~pxi >> %currentDirectory%_outputHTML.txt
echo. >> %currentDirectory%_outputHTML.txt
echo nome file: %%~nxi >> %currentDirectory%_outputHTML.txt
echo. >> %currentDirectory%_outputHTML.txt
type "%%i" >> %currentDirectory%_outputHTML.txt
echo. >> %currentDirectory%_outputHTML.txt
echo =================================================================== >> %currentDirectory%_outputHTML.txt
))
echo stampato html in %currentDirectory%_outputHTML.txt
if %sc% == 1 goto menu
if %sc% == 5 goto typescript

:typescript
echo selezionato TS
for /r %%i in (*.ts) do (

if not %%~nxi == %currentDirectory%_outputTS.txt (
echo Directory e tipo:  %%~pxi >> %currentDirectory%_outputTS.txt
echo. >> %currentDirectory%_outputTS.txt
echo Nome file: %%~nxi >> %currentDirectory%_outputTS.txt
echo. >> %currentDirectory%_outputTS.txt
type "%%i" >> %currentDirectory%_outputTS.txt
echo. >> %currentDirectory%_outputTS.txt
echo =================================================================== >> %currentDirectory%_outputTS.txt
))
echo stampato TS in %currentDirectory%_outputTS.txt
if %sc% == 2 goto menu
if %sc% == 5 goto json

:json
echo selezionato JSON
for /r %%i in (*.json) do (

if not %%~nxi == %currentDirectory%_outputJSON.txt (
echo Directory e tipo:  %%~pxi >> %currentDirectory%_outputJSON.txt
echo. >> %currentDirectory%_outputJSON.txt
echo nome file: %%~nxi >> %currentDirectory%_outputJSON.txt
echo. >> %currentDirectory%_outputJSON.txt
type "%%i" >> %currentDirectory%_outputJSON.txt
echo. >> %currentDirectory%_outputJSON.txt
echo =================================================================== >> %currentDirectory%_outputJSON.txt
))
echo stampato JSON in %currentDirectory%_outputJSON.txt
if %sc% == 3 goto menu
if %sc% == 5 goto css

:css
echo selezionato CSS
for /r %%i in (*.css,*.scss) do (

if not %%~nxi == %currentDirectory%_outputCSS.txt (
echo Directory e tipo:  %%~pxi >> %currentDirectory%_outputCSS.txt
echo. >> %currentDirectory%_outputCSS.txt
echo nome file: %%~nxi >> %currentDirectory%_outputCSS.txt
echo. >> %currentDirectory%_outputCSS.txt
type "%%i" >> %currentDirectory%_outputCSS.txt
echo. >> %currentDirectory%_outputCSS.txt
echo =================================================================== >> %currentDirectory%_outputCSS.txt
))
echo stampato CSS/SCSS in %currentDirectory%_outputCSS.txt
if %sc% == 4 goto menu
if %sc% == 5 goto typescriptts


:typescriptts
echo selezionato TS
for /r %%i in (*.ts) do (

if not %%~nxi == %currentDirectory%_only_outputTS.ts (
echo // Directory e tipo:  %%~pxi >> %currentDirectory%_only_outputTS.ts
echo. >> %currentDirectory%_only_outputTS.ts
echo // Nome file: %%~nxi >> %currentDirectory%_only_outputTS.ts
echo. >> %currentDirectory%_only_outputTS.ts
type "%%i" >> %currentDirectory%_only_outputTS.ts
echo. >> %currentDirectory%_only_outputTS.ts
echo =================================================================== >> %currentDirectory%_only_outputTS.ts
))
echo stampato TS in %currentDirectory%_only_outputTS.TS
if %sc% == 4 goto menu
if %sc% == 5 goto fine

:test
echo selezionato Jasmine
for /r %%i in (*.spec.ts) do (

if not %%~nxi == %currentDirectory%_outputTEST.txt (
echo Directory e tipo:  %%~pxi >> %currentDirectory%_outputTEST.txt
echo. >> %currentDirectory%_outputTEST.txt
echo Nome file: %%~nxi >> %currentDirectory%_outputTEST.txt
echo. >> %currentDirectory%_outputTEST.txt
type "%%i" >> %currentDirectory%_outputTEST.txt
echo. >> %currentDirectory%_outputTEST.txt
echo =================================================================== >> %currentDirectory%_outputTEST.txt
))
echo stampato TEST in %currentDirectory%_outputTEST.txt
if %sc% == 7 goto menu

 
:java
echo selezionato BE
for /r %%i in (*.java,*.vm,*.xml,*.properties,*.config,*.jsp,*.sql)  do (

if not %%~nxi == %currentDirectory%_outputBE.txt (
echo Directory e tipo:  %%~pxi >> %currentDirectory%_outputBE.txt
echo. >> %currentDirectory%_outputBE.txt
echo nome file: %%~nxi >> %currentDirectory%_outputBE.txt
echo. >> %currentDirectory%_outputBE.txt
type "%%i" >> %currentDirectory%_outputBE.txt
echo. >> %currentDirectory%_outputBE.txt
echo =================================================================== >> %currentDirectory%_outputBE.txt
))
echo stampato BE in %currentDirectory%_outputBE.txt
if %sc% == 8 goto menu

:services
echo selezionato Services
for /r %%i in (*.service.ts) do (

if not %%~nxi == %currentDirectory%_outputSERVICES.txt (
echo Directory e tipo:  %%~pxi >> %currentDirectory%_outputSERVICES.txt
echo. >> %currentDirectory%_outputSERVICES.txt
echo Nome file: %%~nxi >> %currentDirectory%_outputSERVICES.txt
echo. >> %currentDirectory%_outputSERVICES.txt
type "%%i" >> %currentDirectory%_outputSERVICES.txt
echo. >> %currentDirectory%_outputSERVICES.txt
echo =================================================================== >> %currentDirectory%_outputSERVICES.txt
))
echo stampato Services in %currentDirectory%_outputSERVICES.txt
if %sc% == 9 goto menu

:componentallonly
echo selezionato component all in one only
for /r %%i in (*.ts,*.html,*.spec.ts) do (

if not %%~nxi == %currentDirectory%componentALL.txt (
echo Directory e tipo:  %%~pxi >> %currentDirectory%componentALL.txt
echo. >> %currentDirectory%componentALL.txt
echo Nome file: %%~nxi >> %currentDirectory%componentALL.txt
echo. >> %currentDirectory%componentALL.txt
type "%%i" >> %currentDirectory%componentALL.txt
echo. >> %currentDirectory%componentALL.txt
echo =================================================================== >> %currentDirectory%componentALL.txt
))
echo stampato Services in %currentDirectory%componentALL.txt
if %sc% == 9 goto menu

:fine
echo fine
pause>nul