import React from "react";
import { PageDashboard } from "./dashboard/PageDashboard";
import { PageConfig } from "./config/PageConfig";
import { Redirect, Route } from "react-router-dom";

export const Routes = ({ projectId }: { projectId: string | undefined }) => (
	<>
		<Route path={"/"} exact>
			{projectId ? (
				<Redirect to={{ pathname: "/dashboard", search: `?dashboardId=${projectId}` }} />
			) : (
				<Redirect to={{ pathname: "/config" }} />
			)}
		</Route>

		<Route path={"/dashboard"} exact>
			{projectId ? <PageDashboard /> : <Redirect to={{ pathname: "/config" }} />}
		</Route>

		<Route path={"/config"} exact>
			{projectId ? (
				<Redirect to={{ pathname: "/dashboard", search: `?projectId=${projectId}` }} />
			) : (
				<PageConfig />
			)}
		</Route>
	</>
);
