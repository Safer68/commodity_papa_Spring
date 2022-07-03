
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="g-header">
    <div class="d-flex justify-content-between">
        <div class="d-flex align-items-center">
            <a class="g-header__sidebar-toggle" href="javascript:void(0)">
                <i class="fas fa-bars"> Commodity Papa</i>
            </a>
        </div>

        <ul class="nav d-flex align-items-center">
            <li class="g-header__nav-item dropdown">
                <a class="g-header__nav-link nav-link dropdown-toggle d-flex active align-items-center"
                   data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                    ${UserName.name} 
                    <i class="g-header__icon g-header__icon--caret fas fa-caret-down"></i>
                </a>
                <div class="g-notification dropdown-menu dropdown-menu-right">
                    <button class="dropdown-item"
                            data-bs-toggle="modal"
                            data-bs-target="#userForm">
                        Личные данные
                    </button>
                    <div class="g-notification__divider dropdown-divider"></div>
                    <form action="${pageContext.request.contextPath}/" name="deleting"
                          method="post">
                        <input type="hidden" name="logOut" value="logOut"/>
                        <button class="dropdown-item">Выйти</button>
                    </form>
                </div>
            </li>
        </ul>
    </div>
</header>

<nav class="g-sidebar">
    <div class="g-sidebar__profile container d-flex active align-items-center">
        <img class="g-sidebar__profile-photo rounded-circle img-fluid"
             src="https://avatars.githubusercontent.com/u/60327596?s=400&v=4"/>

        <div class="g-sidebar__details">
            <span class="g-sidebar__profile-message">Welcome,</span>
            <span class="g-sidebar__profile-name">${UserName.name}</span>
        </div>
    </div>

    <div class="g-sidebar__menu">
        <ul class="g-sidebar__menu-list">

            <li class="g-sidebar__menu-item">
                <a class="g-sidebar__menu-link" href="${pageContext.request.contextPath}/managerPage?pageName=Orders">
                    <i class="g-sidebar__menu-icon far fa-window-restore"></i>
                    <span class="g-sidebar__menu-description">Заказы</span>
                </a>
            </li>
            <li class="g-sidebar__menu-item">
                <a class="g-sidebar__menu-link" href="${pageContext.request.contextPath}/managerPage?pageName=Catalog">
                    <i class="g-sidebar__menu-icon far fa-window-restore"></i>
                    <span class="g-sidebar__menu-description">Каталог</span>
                </a>
            </li>
        </ul>
    </div>
</nav>
