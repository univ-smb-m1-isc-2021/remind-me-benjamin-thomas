import React from "react";
import styled from "styled-components";

const StyledNavbar = styled.ul`
    background-color: "chartreuse";
    width: 100%;
    font-size: 24px;
    list-style-type: none;
    margin: 0;
    padding: 0;
`;

const StyledNavbar = styled.li`
    display: inline;
`;

const Panel = ({jobResult}) => (
    <ul>
        <li>
            <a href="/react">Home</a>
        </li>
        <li>
            <a href="/react/createEvent">Create Event</a>
        </li>
        <li>
            <a href="/react/reminders">My Reminders</a>
        </li>
        <li>
            <a href="/react/parameters">Parameters</a>
        </li>
        <li>
            <a href="/react/profile">Profile</a>
        </li>
    </ul>
);

export default Navbar;