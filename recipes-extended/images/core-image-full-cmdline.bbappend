inherit populate_sdk_qt5

IMAGE_INSTALL:append =  " \
    kmscube \
    wayland \
    glmark2 \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston', \
	   bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11-base x11-sato', \
	                                                   '', d), d)} \
    wayland-utils \
    wayland-protocols \
    ${QT5_IMAGE} \
    "

# Install fonts
QT5_FONTS = "ttf-dejavu-common ttf-dejavu-sans ttf-dejavu-sans-mono ttf-dejavu-serif "

# Install qtquick3d
QT5_QTQUICK3D = "qtquick3d qtquick3d-dev"

# Install Freescale QT demo applications for X11 backend only
MACHINE_QT5_MULTIMEDIA_APPS = ""
QT5_IMAGE_INSTALL = ""
QT5_IMAGE = " \
 	${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'libxkbcommon', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland qtwayland-plugins', '', d)}\
	${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qt3d-dev', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qt3d-qmlplugins', '', d)} \
	qtdeclarative-dev \
	${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtdeclarative-qmlplugins', '', d)} \
	qtmqtt-dev \
	qtmultimedia-dev \
	${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtmultimedia-qmlplugins', '', d)} \
	qtserialport-dev \
	qtserialbus-dev \
	qtwebsockets-dev \
	${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtwebsockets-qmlplugins', '', d)} \
	qtquickcontrols2 \
	qtquickcontrols2-dev \
	qtquickcontrols-qmlplugins \
    qtquick3d \
    qt5-demo-extrafiles \
    qt5everywheredemo \
"
